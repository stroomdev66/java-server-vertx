package vertx.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class DataFeedVerticle extends AbstractVerticle {
    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        vertx.createHttpServer()
                .requestHandler(r -> r.response().end("Welcome to Vert.x Intro"))
                .listen(
                        config().getInteger("http.port", 8090),
                        result -> {
                            if (result.succeeded()) {
                                startPromise.complete();
                            } else {
                                startPromise.fail(result.cause());
                            }
                        });
    }
}
