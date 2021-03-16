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
        {key: "instanceName", value: $filter('translator')('i18n_instance_type', '实例类型'), checked: true, sort: false},
        {key: "workspaceId", value: $filter('translator')('i18n_workspace', '工作空间'), checked: true, sort: false},
        {key: "account", value: $filter('translator')('i18n_engine', '引擎'), checked: true, sort: false},
        {key: "region", value: $filter('translator')('i18n_engine_version', '引擎版本'), checked: true, sort: false}
    ];

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

    $scope.list = function (sortObj) {
        let condition = FilterSearch.convert($scope.filters);
        if (sortObj || $scope.sort) {
            $scope.sort = sortObj || $scope.sort;
        }
        if ($scope.sort) {
            condition.sort = $scope.sort.sql;
        }
        condition = condition ? condition : {};
        HttpUtils.paging($scope, 'flavor/list', condition);
    };

    $scope.list();

});
