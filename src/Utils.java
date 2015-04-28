import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.List;

/**
 * Created by fuliang on 2015/4/9.
 */
public class Utils {
    public static <T> void  printNestList(List<List<T>> nestLists) {
        for (int i = 0; i < nestLists.size(); i++) {
            List<T> list = nestLists.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
