package EJB;

import javax.ejb.Stateless;


@Stateless
public class SubtractionLogic {

    public int Subtraction(int a, int b) {
        return a-b;
    }
}