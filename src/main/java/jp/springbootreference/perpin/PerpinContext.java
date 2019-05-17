package jp.springbootreference.perpin;

import jp.springbootreference.perpin.domain.model.AppStatus;
import jp.springbootreference.perpin.exception.PerpinException;

import java.util.HashMap;

public class PerpinContext {


    private static HashMap<Integer, AppStatus> appStatusContexts;

    static{
        appStatusContexts = new HashMap<>();
    }


    public static void setStatus(Integer id , AppStatus appStatus){

        // throw error if user set application.
        if(appStatusContexts.containsKey(id)){
            throw new PerpinException(String.format("Perpin Context Error! context-id &d already set.",id));
        }

        appStatusContexts.put(id,appStatus);

    }


    public static AppStatus getStatus(Integer id){

        // throw error if user try to get non-exist app status.
        if(!appStatusContexts.containsKey(id)){
            throw new PerpinException(String.format("Perpin Context Error! context with id &d doesn' exist.",id));
        }

        return appStatusContexts.get(id);
    }

    public static void deleteContext(Integer id){

        // throw error if user try to get non-exist app status.
        if(!appStatusContexts.containsKey(id)){
            throw new PerpinException(String.format("Perpin Context Error! context with id &d doesn' exist.",id));
        }

        appStatusContexts.remove(id);

    }

}
