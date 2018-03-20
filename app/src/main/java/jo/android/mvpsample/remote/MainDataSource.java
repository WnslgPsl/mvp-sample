package jo.android.mvpsample.remote;

import jo.android.mvpsample.view.main.data.PhotoResponse;

/**
 * 설계도
 */
public interface MainDataSource {

    interface LoadFlickrCallback <T>{
        void onSuccess(T t);
        void onFailure(String message);
    }

    void getSearchPhotos(String format, String nojsoncallback, String method, String searchKeyword, String flickrKey, int requestPage,
                         int requestPerPage, LoadFlickrCallback<PhotoResponse> callback);

}
