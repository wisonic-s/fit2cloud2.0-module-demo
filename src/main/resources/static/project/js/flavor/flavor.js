ProjectApp.controller('FlavorListCtrl', function ($scope, HttpUtils, Notification, FilterSearch, AuthService, $timeout, $state,$filter) {


    $scope.period = [1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 24, 36, 48, 60];

    $scope.conditions = [
        {key: "instanceName", name: $filter('translator')('i18n_Name', '名称'), directive: "filter-contains"},
        {
            key: "statuses",
            name: $filter('translator')('i18n_status', '状态'),
            directive: "filter-select-multiple",
            selects: [
                {value: "Running", label: $filter('translator')('i18n_run', '运行')},
                {value: "Deleted", label: $filter('translator')('i18n_deleted', '已删除')},
                {value: "Restarting", label: $filter('translator')('i18n_Restarting', '重启中')},
                {value: "Creating", label: $filter('translator')('i18n_creating', '创建中')}
            ]
        }
    ];

    // 用于传入后台的参数
    $scope.filters = [{
        key: "statuses",
        name: $filter('translator')('i18n_status', '状态'),
        value: ['Running', 'Restarting'],
        label: 'Running, Restarting'
    }];
    $scope.serverAddresses = [];

    if ($scope.orderVSParam) {
        $scope.filters = [{
            key: "orderId",
            name: $filter('translator')('i18n_order_number', '订单号'),
            operator: "=",
            label: $scope.orderVSParam.label,
            value: $scope.orderVSParam.value
        }];
    }

    $scope.first = {
        default: true,
        sort: false,
        type: "checkbox",
        checkValue: false,
        change: function (checked) {
            $scope.items.forEach(function (item) {
                item.enable = checked;
            });
        },
        width: "40px"
    };

    $scope.columns = [
        $scope.first,
        {key: "instanceName", value: $filter('translator')('i18n_Name', '名称'), checked: true, sort: false},
        {key: "workspaceId", value: $filter('translator')('i18n_workspace', '工作空间'), checked: true, sort: false},
        {key: "account", value: $filter('translator')('i18n_account', '云账号'), checked: true, sort: false},
        {key: "region", value: $filter('translator')('i18n_region', '区域'), checked: true, sort: false},
        {key: "vpc", value: "VPC", checked: true, sort: false},
        {key: "engine", value: $filter('translator')('i18n_Type', '类型'), checked: true, sort: false},
        {key: "engineVersion", value: $filter('translator')('i18n_Edition', '版本'), checked: true, sort: false},
        {key: "instanceClass", value: $filter('translator')('i18n_specification', '规格'), checked: true, sort: false},
        {key: "status", value: $filter('translator')('i18n_status', '状态'), checked: true, sort: false},
        {key: "chargingMode", value: $filter('translator')('i18n_Type_of_payment', '付费类型'), checked: true, sort: false},
        {key: "ip", value: $filter('translator')('i18n_ip_address', 'IP地址'), checked: true, sort: false},
        {key: "port", value: $filter('translator')('i18n_port', '端口'), checked: true, sort: false},
        {key: "createTime", value: $filter('translator')('i18n_create_time', '创建时间'), checked: true, sort: false}
    ];

    $scope.authList = [
        {"id": "workspace", "name": $filter('translator')('i18n_Authorize_to_workspace', '授权到工作空间')},
        {"id": "root", "name": $filter('translator')('i18n_Deauthorize', '取消授权')}
    ];
    $scope.listToString = function (arr) {
        return arr.join(",");
    };

    $scope.workspaceList = [];
    $scope.changeOrg = function (orgId) {
        if (!orgId) {
            $scope.workspaceList = [];
            return;
        }
        angular.forEach($scope.organizations, function (organization) {
            if (organization.id === orgId) {
                $scope.workspaceList = organization.children;
            }
        })
    };

    $scope.batchDelete = function () {
        let ids = [];
        $scope.getItemIds(ids);
        if (ids.length === 0) {
            Notification.info($filter('translator')('i18n_No_action_item_selected', '未选择操作项'));
            return;
        }
        Notification.confirm($filter('translator')('i18n_menu_delete_confirm', '确认删除')+' ?', function () {
            $scope.loadingLayer = HttpUtils.post('dcs/batch/delete', ids, function () {
                Notification.success($filter('translator')('i18n_menu_delete_success', '删除成功'));
                $scope.list();
            }, function (response) {
                Notification.danger($filter('translator')('i18n_menu_delete_fail', '删除失败')+', ' + response.message);
            });
        });
    };

    $scope.delete = function (id) {
        Notification.confirm($filter('translator')('i18n_menu_delete_confirm', '确认删除')+' ?', function () {
            $scope.loadingLayer = HttpUtils.get('dcs/delete/' + id, function () {
                Notification.success($filter('translator')('i18n_menu_delete_success', '删除成功'));
                $scope.list();
            }, function (response) {
                Notification.danger($filter('translator')('i18n_menu_delete_fail', '删除失败')+', ' + response.message);
            });
        });
    };




    $scope.createInstance = function () {
        $scope.formUrl = "project/html/redis/redis-add.html?_t="+ Math.random();
        $scope.toggleForm();
    };

    $scope.getItemIds = function (ids) {
        angular.forEach($scope.items, function (item) {
            if (item.enable) {
                ids.push(item.id);
            }
        });
    };

    $scope.getCredentialDetails = function (accountId, attr) {
        if (!$scope.accountList) {
            return;
        }
        for (let i = 0; i < $scope.accountList.length; i++) {
            if ($scope.accountList[i].id === accountId) {
                return $scope.accountList[i][attr];
            }
        }
        return "";
    };

    $scope.addParam = function (serverAddresses) {
        let newParam = {"ip": ""};
        serverAddresses.push(newParam);
    };
    $scope.removeParam = function (parameter, p) {
        for (let i in parameter) {
            if (parameter[i].ip === p.ip && parameter[i].port === p.port) {
                parameter.splice(i, 1);
            }
        }
    };

    $scope.grantInstances = function () {
        $scope.serverIds = $scope.items.filter(function (value) {
            return value.enable;
        }).map(function (value) {
            return value.id;
        });
        if ($scope.serverIds.length === 0) {
            Notification.info($filter('translator')('i18n_select_instance', '请选择实例'));
            return;
        }
        $scope.authItem = {};
        $scope.formUrl = 'project/html/dcs/workspace-authorized.html' + '?_t=' + Math.random();
        $scope.toggleForm();
        $scope.grantLoadingLayer = HttpUtils.get('workspace/grant/all', function (response) {
            $scope.organizations = response.data;
        });
    };


    $scope.grantInstancesSubmit = function (workspaceId, selectMode) {
        if (selectMode === 'root') {
            workspaceId = 'root';
        }
        if ($scope.serverIds.length === 0) {
            Notification.info($filter('translator')('i18n_select_virtual_machine', '请选择数据库'));
            return;
        }
        $scope.loadingLayer = HttpUtils.post('dcs/grant/' + workspaceId, $scope.serverIds, function () {
            Notification.success($filter('translator')('i18n_Authorization_succeeded', '授权成功'));
            $scope.list();
        });
        $scope.toggleForm();
    };

    $scope.showInformation = function () {
        $scope.infoUrl = 'project/html/dcs/resource-information.html' + '?_t=' + window.appversion;
        $scope.toggleInfoForm(true);
        $scope.$broadcast('showDetail');
    };

    $scope.showDetail = function (item) {
        $scope.detail = item;
        $scope.showInformation();
    }

    $scope.restart = function (id) {
        Notification.confirm($filter('translator')('i18n_Confirm_restart', '确认重启 ?'), function () {
            $scope.loadingLayer = HttpUtils.get('dcs/reboot/' + id, function () {
                Notification.success($filter('translator')('i18n_Restart_task_submitted_successfully', '重启任务提交成功！'));
                $scope.list();
            }, function (response) {
                Notification.danger($filter('translator')('i18n_Restart_failed', '重启失败, ') + response.message);
            });
        });
    }

    $scope.openIpList = function (item) {
        $state.go("node", {poolId: item.poolId});
    };

    $scope.list = function (sortObj) {
        let condition = FilterSearch.convert($scope.filters);
        if (sortObj || $scope.sort) {
            $scope.sort = sortObj || $scope.sort;
        }
        if ($scope.sort) {
            condition.sort = $scope.sort.sql;
        }
        condition = angular.merge(condition, {"engine": "Redis"});
        condition = condition ? condition : {};
        HttpUtils.paging($scope, 'dcs/list', condition)
    };

    $scope.list();

    $scope.getExtendInfo = function (item) {
        let itemInNewQueryResult = false;
        $scope.items.forEach(function (mongo) {
            if (item && mongo.id === item.id) {
                itemInNewQueryResult = true;
            }
        });
        if (itemInNewQueryResult === false) {
            return;
        }
        if (item.status === "Restarting") {
            HttpUtils.post('rds/getStats', item, function (response) {
                item.status = response.data.status;
                if (response.data.status === "Restarting") {
                    let promise = $timeout(function () {
                        $scope.getExtendInfo(item);
                    }, 5000);
                }
            }, function (response) {
                Notification.danger($filter('translator')('i18n_Failed_synchronize_status', '同步rds状态失败,') + response.message);
            });
        }
    };
});
