package org.example;

import com.vonage.client.VonageClient;

public class App{
    public static void main(String[] args) {

		    String TO_NUMBER = System.getenv("TO_NUMBER");

        VonageClient client = VonageClient.builder()
				  .applicationId(System.getenv("VONAGE_APPLICATION_ID"))
				  .privateKeyPath(System.getenv("VONAGE_PRIVATE_KEY_PATH"))
          .build();

        /*
         * SIM Swap Check
         */
        try {
            System.out.println(client.getSimSwapClient().checkSimSwap(TO_NUMBER, 501));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*
         * SIM Swap retrieve date
         */
        try {
            System.out.println(client.getSimSwapClient().retrieveSimSwapDate(TO_NUMBER));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*
         * Device Status get connectivity
         */
        try {
            System.out.println(client.getDeviceStatusClient().getConnectivityStatus(TO_NUMBER));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*
         * Device Status get roaming
         */
        try {
            var roaming = client.getDeviceStatusClient().getRoamingStatus(TO_NUMBER);
            System.out.println(roaming.getRoaming());
            System.out.println(roaming.getCountryCode());
            System.out.println(roaming.getCountryName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

