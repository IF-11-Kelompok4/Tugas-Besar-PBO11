/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kas.kelompok4.tugasbesar.error;

/**
 *
 * @author Star Ramadhan
 */
public class MaskasException extends Exception {

    /**
     * Creates a new instance of <code>iuranException</code> without detail
     * message.
     */
    public MaskasException() {
    }

    /**
     * Constructs an instance of <code>iuranException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public MaskasException(String msg) {
        super(msg);
    }
}
