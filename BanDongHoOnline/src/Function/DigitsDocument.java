/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
//offs: offset (Phần bù) trong tl đc y cầu >=0
//AttributeSet: bộ thuộc tính
//BadLocationException : báo cáo vị trí k tồn tại
//PlainDocument: TL k có thuộc tính kí tự
public class DigitsDocument extends PlainDocument {

    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }
        char[] add = str.toCharArray();
        char c;
        for (int i = add.length; i > 0; i--) {
            c = add[i - 1];
            if (Character.isDigit(c)) {
                super.insertString(offs, new String(new Character(c).toString()), a);
            }
        }

    }
}
