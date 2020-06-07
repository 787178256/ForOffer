package cleancode;

import java.util.Iterator;

/**
 * Created by kimvra on 2020/4/28
 */
public interface ArgumentMarshaler {
    void set(Iterator<String> currentArgument) throws ArgsException;
}
