package logInUseCase;

/**
 * this Exception might be customised later, but it is renamed to understand quickly what exactly
 * went wrong when debugging. For example, the username that user passed when registering already exists,
 * so method userRegister in LogInInteractor throws an InvalidInputException and
 * passes the corresponding error message.
 */
public class InvalidInputException extends  Exception{

}
