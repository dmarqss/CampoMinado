package campoMinado.customExeptions;

import java.io.IOException;

public class InvalidInputExeption extends IOException {
    public InvalidInputExeption() {
        super("INPUT INVALIDO");
    }
}
