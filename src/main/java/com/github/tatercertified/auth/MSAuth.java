package com.github.tatercertified.auth;

import com.google.gson.JsonObject;
import net.raphimc.mcauth.MinecraftAuth;
import net.raphimc.mcauth.step.java.StepMCProfile;
import net.raphimc.mcauth.step.msa.StepCredentialsMsaCode;
import net.raphimc.mcauth.step.msa.StepMsaDeviceCode;
import net.raphimc.mcauth.util.MicrosoftConstants;
import org.apache.http.impl.client.CloseableHttpClient;

public class MSAuth {
    public static boolean isAuthenticated = false;
    public static String loginMicrosoft(String email, String password) {

        // Log in using credentials
        try (final CloseableHttpClient httpClient = MicrosoftConstants.createHttpClient()) {
            StepMCProfile.MCProfile mcProfile = MinecraftAuth.JAVA_CREDENTIALS_LOGIN.getFromInput(httpClient, new StepCredentialsMsaCode.MsaCredentials(email, password));
            System.out.println("Logged in with access token: " + mcProfile.prevResult().prevResult().access_token());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Log in using device code (Blocks until the user has logged in or timeout is reached)
        StepMCProfile.MCProfile mcProfile;
        try (final CloseableHttpClient httpClient = MicrosoftConstants.createHttpClient()) {
            mcProfile = MinecraftAuth.JAVA_DEVICE_CODE_LOGIN.getFromInput(httpClient, new StepMsaDeviceCode.MsaDeviceCodeCallback(msaDeviceCode -> {
                System.out.println("Go to " + msaDeviceCode.verificationUri());
                System.out.println("Enter code " + msaDeviceCode.userCode());
            }));
            System.out.println("Logged in as: " + mcProfile.name());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Save the whole chain of tokens
        final JsonObject serializedProfile = mcProfile.toJson();

        // Load the chain of tokens
        StepMCProfile.MCProfile loadedProfile;
        try {
             loadedProfile = MinecraftAuth.JAVA_DEVICE_CODE_LOGIN.fromJson(serializedProfile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Refresh the chain of tokens (It only refreshes those necessary)
        try (final CloseableHttpClient httpClient = MicrosoftConstants.createHttpClient()) {
            loadedProfile = MinecraftAuth.JAVA_DEVICE_CODE_LOGIN.refresh(httpClient, mcProfile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        isAuthenticated = true;
        // loadedProfile is now valid again and can be used

        return mcProfile.prevResult().prevResult().access_token();
    }
}
