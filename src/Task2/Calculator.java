package Task2;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Calculator {
    public String calculate(String text) throws Exception {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
        Object sol = scriptEngine.eval(text);
        String solution = sol + "";
        return solution;
    }
}
