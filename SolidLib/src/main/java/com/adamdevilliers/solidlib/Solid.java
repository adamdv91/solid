package com.adamdevilliers.solidlib;

import com.adamdevilliers.solidlib.api.SolidClient;
import com.adamdevilliers.solidlib.api.response.MockyResponse;
import com.adamdevilliers.solidlib.models.City;
import com.adamdevilliers.solidlib.models.Mall;
import com.adamdevilliers.solidlib.models.Shop;
import com.adamdevilliers.solidlib.exceptions.ItemNotFoundException;
import com.adamdevilliers.solidlib.exceptions.NetworkCallException;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Solid implements SolidSDK {

    private SolidClient solidClient;

    Solid(SolidClient solidClient) {
        this.solidClient = solidClient;
    }

    /**
     * Asynchronously request a list of all cities and notify the {@code callback} of its response with either
     * {@code onSuccess} or {@code onFailure}
     *
     * @param callback - Result callback
     */
    @Override
    public void getCities(final SolidCallback<List<City>> callback) {
        solidClient.getSolidResponse(new Callback<MockyResponse>() {
            @Override
            public void onResponse(Call<MockyResponse> call, Response<MockyResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().getCities());
                }
            }

            @Override
            public void onFailure(Call<MockyResponse> call, Throwable t) {
                NetworkCallException networkCallException = new NetworkCallException("An error has occurred", t);
                callback.onFailure(networkCallException);
            }
        });
    }

    /**
     * Asynchronously request a single city based on the developers
     * cityId
     * and notify the {@code callback} of its response with either
     * {@code onSuccess} or {@code onFailure}
     *
     * @param cityId - ID of the city to be queried
     * @param callback - Result callback
     */
    @Override
    public void getCity(final int cityId, final SolidCallback<City> callback) {
        solidClient.getSolidResponse(new Callback<MockyResponse>() {
            @Override
            public void onResponse(Call<MockyResponse> call, Response<MockyResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    for (int i = 0; i < response.body().getCities().size(); i++) {
                        if (response.body().getCities().get(i).getId() == cityId) {
                            callback.onSuccess(response.body().getCities().get(i));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<MockyResponse> call, Throwable t) {
                NetworkCallException networkCallException = new NetworkCallException("An error has occurred", t);
                callback.onFailure(networkCallException);
            }
        });
    }

    /**
     * Asynchronously request a list of all malls based on the developers
     * cityId
     * and notify the {@code callback} of its response with either
     * {@code onSuccess} or {@code onFailure}
     *
     * @param cityId - ID of the city to be queried
     * @param callback - Result callback
     */
    @Override
    public void getMalls(final int cityId, final SolidCallback<List<Mall>> callback) {
        solidClient.getSolidResponse(new Callback<MockyResponse>() {
            @Override
            public void onResponse(Call<MockyResponse> call, Response<MockyResponse> response) {
                List<Mall> malls = new ArrayList<>();
                if (response.isSuccessful() && response.body() != null) {
                    for (int i = 0; i < response.body().getCities().size(); i++) {
                        if (response.body().getCities().get(i).getId() == cityId) {
                            malls.addAll(response.body().getCities().get(i).getMalls());
                        }
                    }

                    if (malls.size() == 0) {
                        ItemNotFoundException itemNotFoundException = new ItemNotFoundException("There was no match for cityId: " + cityId);
                        itemNotFoundException.printStackTrace();
                    }
                }
                callback.onSuccess(malls);
            }

            @Override
            public void onFailure(Call<MockyResponse> call, Throwable t) {
                NetworkCallException networkCallException = new NetworkCallException("An error has occurred", t);
                callback.onFailure(networkCallException);
            }
        });
    }

    /**
     * Asynchronously request a a single mall based on the developers
     * cityId and mallId
     * and notify the {@code callback} of its response with either
     * {@code onSuccess} or {@code onFailure}
     *
     * @param mallId - ID of the mall to be queried
     * @param cityId - ID of the city to be queried
     * @param callback - Result callback
     */
    @Override
    public void getMall(final int cityId, final int mallId, final SolidCallback<Mall> callback) {
        solidClient.getSolidResponse(new Callback<MockyResponse>() {

            @Override
            public void onResponse(Call<MockyResponse> call, Response<MockyResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    for (int i = 0; i < response.body().getCities().size(); i++) {
                        if (response.body().getCities().get(i).getId() == cityId) {
                            for (int j = 0; j < response.body().getCities().get(i).getMalls().size(); j++) {
                                if (response.body().getCities().get(i).getMalls().get(j).getId() == mallId) {
                                    callback.onSuccess(response.body().getCities().get(i).getMalls().get(j));
                                }
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<MockyResponse> call, Throwable t) {
                NetworkCallException networkCallException = new NetworkCallException("An error has occurred", t);
                callback.onFailure(networkCallException);
            }
        });
    }

    /**
     * Asynchronously request a list of shops in a mall based on the developers
     * mallId
     * and notify the {@code callback} of its response with either
     * {@code onSuccess} or {@code onFailure}
     *
     * @param mallId - ID of the mall to be queried
     * @param callback - Result callback
     */
    @Override
    public void getShops(final int mallId, final SolidCallback<List<Shop>> callback) {
        solidClient.getSolidResponse(new Callback<MockyResponse>() {
            @Override
            public void onResponse(Call<MockyResponse> call, Response<MockyResponse> response) {
                List<Shop> shops = new ArrayList<>();
                if (response.isSuccessful() && response.body() != null) {
                    for (int i = 0; i < response.body().getCities().size(); i++) {
                        for (int j = 0; j < response.body().getCities().get(i).getMalls().size(); j++) {
                            if (response.body().getCities().get(i).getMalls().get(j).getId() == mallId) {
                                shops.addAll(response.body().getCities().get(i).getMalls().get(j).getShops());
                            }
                        }
                    }
                }

                if (shops.size() == 0) {
                    ItemNotFoundException itemNotFoundException = new ItemNotFoundException("There was no match for mallId: " + mallId);
                    itemNotFoundException.printStackTrace();
                }
                callback.onSuccess(shops);
            }

            @Override
            public void onFailure(Call<MockyResponse> call, Throwable t) {
                NetworkCallException networkCallException = new NetworkCallException("An error has occurred", t);
                callback.onFailure(networkCallException);
            }
        });
    }

    /**
     * Asynchronously request a list of shops in a city based on the developers
     *  cityId
     * and notify the {@code callback} of its response with either
     * {@code onSuccess} or {@code onFailure}
     *
     * @param cityId - ID of the mall to be queried
     * @param callback - Result callback
     */
    @Override
    public void getShopsForCity(final int cityId, final SolidCallback<List<Shop>> callback) {
        solidClient.getSolidResponse(new Callback<MockyResponse>() {
            @Override
            public void onResponse(Call<MockyResponse> call, Response<MockyResponse> response) {
                List<Shop> shops = new ArrayList<>();
                if (response.isSuccessful() && response.body() != null) {
                    for (int i = 0; i < response.body().getCities().size(); i++) {
                        if (response.body().getCities().get(i).getId() == cityId) {
                            for (int j = 0; j < response.body().getCities().get(i).getMalls().size(); j++) {
                                shops.addAll(response.body().getCities().get(i).getMalls().get(j).getShops());
                            }
                        }
                    }
                }
                if (shops.size() == 0) {
                    ItemNotFoundException itemNotFoundException = new ItemNotFoundException("There was no match for cityId: " + cityId);
                    itemNotFoundException.printStackTrace();
                }
                callback.onSuccess(shops);

            }

            @Override
            public void onFailure(Call<MockyResponse> call, Throwable t) {
                NetworkCallException networkCallException = new NetworkCallException("An error has occurred", t);
                callback.onFailure(networkCallException);
            }
        });
    }

    /**
     * Asynchronously request a single shop based on the developers
     * mallId and shopId
     * and notify the {@code callback} of its response with either
     * {@code onSuccess} or {@code onFailure}
     *
     * @param mallId - ID of the mall to be queried
     * @param shopId - ID of the shop to be queried
     * @param callback - Result callback
     */
    @Override
    public void getShop(final int mallId, final int shopId, final SolidCallback<Shop> callback) {
        solidClient.getSolidResponse(new Callback<MockyResponse>() {

            @Override
            public void onResponse(Call<MockyResponse> call, Response<MockyResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    for (int i = 0; i < response.body().getCities().size(); i++) {
                        for (int j = 0; j < response.body().getCities().get(i).getMalls().size(); j++) {
                            if (response.body().getCities().get(i).getMalls().get(j).getId() == mallId) {
                                for (int k = 0; k < response.body().getCities().get(i).getMalls().get(j).getShops().size(); k++) {
                                    if (response.body().getCities().get(i).getMalls().get(j).getShops().get(k).getId() == shopId) {
                                        callback.onSuccess(response.body().getCities().get(i).getMalls().get(j).getShops().get(k));
                                    }
                                }
                            }
                        }
                    }
                }

            }


            @Override
            public void onFailure(Call<MockyResponse> call, Throwable t) {
                NetworkCallException networkCallException = new NetworkCallException("An error has occurred", t);
                callback.onFailure(networkCallException);
            }
        });
    }
}