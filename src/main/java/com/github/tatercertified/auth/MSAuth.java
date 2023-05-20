package com.github.tatercertified.auth;

import net.raphimc.mcauth.MinecraftAuth;
import net.raphimc.mcauth.step.java.StepMCProfile;
import net.raphimc.mcauth.step.msa.StepCredentialsMsaCode;
import net.raphimc.mcauth.util.MicrosoftConstants;
import org.apache.http.impl.client.CloseableHttpClient;

public class MSAuth {
    public static boolean isAuthenticated = false;
    public static String loginMicrosoft(String email, String password) {

        // Log in using credentials
        StepMCProfile.MCProfile mcProfile;
        try (final CloseableHttpClient httpClient = MicrosoftConstants.createHttpClient()) {
            mcProfile = MinecraftAuth.JAVA_CREDENTIALS_LOGIN.getFromInput(httpClient, new StepCredentialsMsaCode.MsaCredentials(email, password));
            System.out.println("Logged in with access token: " + mcProfile.prevResult().prevResult().access_token());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        isAuthenticated = true;
        return mcProfile.prevResult().prevResult().access_token();
    }
}
