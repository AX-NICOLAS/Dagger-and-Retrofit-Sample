package fr.ineat.dagger.contrast;

import java.util.List;

import fr.ineat.dagger.model.Contributor;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

import static fr.ineat.dagger.contrast.Constant.API_URL_CONTRIBUTOR;
/**
 * Created by nicolasbro on 30/09/2014.
 */
public interface IApiRequest {

    @GET(API_URL_CONTRIBUTOR)
    Observable<List<Contributor>> contributors(@Path("owner") String owner,@Path("repo") String repo);
}
