package top.jolyoulu.pipline;

/**
 * @Author: JolyouLu
 * @Date: 2021/5/10 14:06
 * @Version 1.0
 * 重新的RequestHandler处理父类
 */
public abstract class AbstractRequestHandlerContext{

    //当前处理对象的下一个处理者
    protected AbstractRequestHandlerContext requestHandlerContext;
    //Handler名字
    protected String name;

    public AbstractRequestHandlerContext(String name){
        this.name = name;
    }

    public AbstractRequestHandlerContext getRequestHandlerContext() {
        return requestHandlerContext;
    }

    public void setRequestHandlerContext(AbstractRequestHandlerContext requestHandlerContext) {
        this.requestHandlerContext = requestHandlerContext;
    }

    //处理Handler重新方法
    public abstract void requestHandle(RequestContext requestContext);

}
