package com.adamdevilliers.solidlib;

import com.adamdevilliers.solidlib.api.SolidClient;
import com.adamdevilliers.solidlib.api.response.GetListOfMallsResponse;
import com.adamdevilliers.solidlib.api.response.models.Cities;
import com.adamdevilliers.solidlib.api.response.models.Malls;
import com.adamdevilliers.solidlib.api.response.models.Shops;
import com.adamdevilliers.solidlib.errorhandling.ItemNotFoundException;
import com.adamdevilliers.solidlib.errorhandling.NetworkCallException;

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

    /*
      Solid sdk getCities is used to collect all the cities response data
    */
    @Override
    public void getCities(final SolidCallback<List<Cities>> callback) {
        solidClient.getCities(new Callback<GetListOfMallsResponse>() {
            @Override
            public void onResponse(Call<GetListOfMallsResponse> call, Response<GetListOfMallsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().getCities());
                }
            }

            @Override
            public void onFailure(Call<GetListOfMallsResponse> call, Throwable t) {
                NetworkCallException networkCallException = new NetworkCallException("An error has occurred", t);
                callback.onFailure(networkCallException);
            }
        });
    }

    /*
      Solid sdk getCity is used to collect just one city based on the cityId provided
     */
    @Override
    public void getCity(final int cityId, final SolidCallback<Cities> callback) {
        solidClient.getCities(new Callback<GetListOfMallsResponse>() {
            @Override
            public void onResponse(Call<GetListOfMallsResponse> call, Response<GetListOfMallsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    for (int i = 0; i < response.body().getCities().size(); i++) {
                        if (response.body().getCities().get(i).getId() == cityId) {
                            callback.onSuccess(response.body().getCities().get(i));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<GetListOfMallsResponse> call, Throwable t) {
                NetworkCallException networkCallException = new NetworkCallException("An error has occurred", t);
                callback.onFailure(networkCallException);
            }
        });
    }

     /*
        Solid sdk getMalls is used to collect all the malls based on the cityId that the user has provided
     */
    @Override
    public void getMalls(final int cityId, final SolidCallback<List<Malls>> callback) {
        solidClient.getMalls(new Callback<GetListOfMallsResponse>() {
            @Override
            public void onResponse(Call<GetListOfMallsResponse> call, Response<GetListOfMallsResponse> response) {
                List<Malls> malls = new ArrayList<>();
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
            public void onFailure(Call<GetListOfMallsResponse> call, Throwable t) {
                NetworkCallException networkCallException = new NetworkCallException("An error has occurred", t);
                callback.onFailure(networkCallException);
            }
        });
    }

    /*
        Solid sdk getMall is used to collect one mall based on the city that the user has provided
     */
    @Override
    public void getMall(final int cityId, final int mallId, final SolidCallback<Malls> callback) {
        solidClient.getMalls(new Callback<GetListOfMallsResponse>() {

            @Override
            public void onResponse(Call<GetListOfMallsResponse> call, Response<GetListOfMallsResponse> response) {
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
            public void onFailure(Call<GetListOfMallsResponse> call, Throwable t) {
                NetworkCallException networkCallException = new NetworkCallException("An error has occurred", t);
                callback.onFailure(networkCallException);
            }
        });
    }

     /*
        Solid sdk getShops is used to collect all the shops based on the mallId that the user has provided
     */
    @Override
    public void getShops(final int mallId, final SolidCallback<List<Shops>> callback) {
        solidClient.getShops(new Callback<GetListOfMallsResponse>() {
            @Override
            public void onResponse(Call<GetListOfMallsResponse> call, Response<GetListOfMallsResponse> response) {
                List<Shops> shops = new ArrayList<>();
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
            public void onFailure(Call<GetListOfMallsResponse> call, Throwable t) {
                NetworkCallException networkCallException = new NetworkCallException("An error has occurred", t);
                callback.onFailure(networkCallException);
            }
        });
    }

    /*
        Solid sdk getShops is used to collect all the shops based on the cityId that the user has provided
     */
    @Override
    public void getShopsForCity(final int cityId, final SolidCallback<List<Shops>> callback) {
        solidClient.getShops(new Callback<GetListOfMallsResponse>() {
            @Override
            public void onResponse(Call<GetListOfMallsResponse> call, Response<GetListOfMallsResponse> response) {
                List<Shops> shops = new ArrayList<>();
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
            public void onFailure(Call<GetListOfMallsResponse> call, Throwable t) {
                NetworkCallException networkCallException = new NetworkCallException("An error has occurred", t);
                callback.onFailure(networkCallException);
            }
        });
    }

    /*
        Solid sdk getShop is used to collect one shop based on the cityId and mallId that the user has provided
     */
    @Override
    public void getShop(final int mallId, final int shopId, final SolidCallback<Shops> callback) {
        solidClient.getShops(new Callback<GetListOfMallsResponse>() {

            @Override
            public void onResponse(Call<GetListOfMallsResponse> call, Response<GetListOfMallsResponse> response) {
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
            public void onFailure(Call<GetListOfMallsResponse> call, Throwable t) {
                NetworkCallException networkCallException = new NetworkCallException("An error has occurred", t);
                callback.onFailure(networkCallException);
            }
        });
    }
}