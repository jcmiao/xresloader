package org.xresloader.core.data.dst;

public class CppDll {
    static {
        System.loadLibrary("lua_col");
    }

    public native void init_cpp_dll();
    public native String do_lua_string(String s);

    private static CppDll _instance = null;
    public static CppDll getInstance() {
        if (_instance == null)
        {
            _instance = new CppDll();
            _instance.init_cpp_dll();
        }
        return _instance;
    }

    public String lua_convert(String s) {
        if (s == null)
        {
            return null;
        }

        String ret = do_lua_string(s);
        if (ret == null || ret.length() == 0 || ret.charAt(0) == '0')
        {
            return null;
        }
        return ret.substring(1);
    }
}
