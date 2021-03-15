package com.fit2cloud.cache;

import com.huaweicloud.sdk.core.auth.BasicCredentials;
import com.huaweicloud.sdk.core.auth.ICredential;
import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.core.region.Region;
import com.huaweicloud.sdk.dcs.v2.DcsClient;
import com.huaweicloud.sdk.dcs.v2.model.*;
import com.huaweicloud.sdk.dcs.v2.region.DcsRegion;
import org.junit.Test;

public class NormalTest {
    public final static String AK = "";
    public final static String SK = "";

    public final static BasicCredentials CREDENTIALS = new BasicCredentials()
            .withAk(AK)
            .withSk(SK);

    public static void main(String[] args) {


        ICredential auth = new BasicCredentials()
                .withAk(AK)
                .withSk(SK);

        DcsClient client = DcsClient.newBuilder()
                .withCredential(auth)
                .withRegion(DcsRegion.CN_NORTH_4)
                .build();
        ListInstancesRequest request = new ListInstancesRequest();
        try {
            ListInstancesResponse response = client.listInstances(request);
            System.out.println(response.toString());
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (RequestTimeoutException e) {
            e.printStackTrace();
        } catch (ServiceResponseException e) {
            e.printStackTrace();
            System.out.println(e.getHttpStatusCode());
            System.out.println(e.getErrorCode());
            System.out.println(e.getErrorMsg());
        }
    }

    public static DcsClient getClient(Region region) {

        return DcsClient.newBuilder().withRegion(region)
                .withCredential(CREDENTIALS)
                .build();
    }

    @Test
    public void testCreateInstance() {
        DcsClient client = getClient(DcsRegion.CN_NORTH_4);
    }
}
