package demo.springboot.quickstarts.kitchensink.exception;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(Long id) {
        super("could not find member " + id);
    }
}
