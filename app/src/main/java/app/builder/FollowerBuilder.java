package app.builder;

import app.beans.FollowerBean;
import app.builder.interfaces.Builder;

import java.io.Serializable;

public class FollowerBuilder implements Serializable, Builder<FollowerBean> {

    private Long idUsuarioToFollow;
    private Long idFollower;

    public FollowerBuilder(Long idUsuarioToFollow, Long idFollower) {
        this.idUsuarioToFollow = idUsuarioToFollow;
        this.idFollower = idFollower;
    }

    public FollowerBean build() {
        return new FollowerBean(idUsuarioToFollow, idFollower);
    }
}
