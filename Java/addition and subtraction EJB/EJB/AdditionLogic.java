
package EJB;

import javax.ejb.Stateless;


@Stateless
public class AdditionLogic {

    public int Addition(int a, int b) {
        return a+b;
    } 
}