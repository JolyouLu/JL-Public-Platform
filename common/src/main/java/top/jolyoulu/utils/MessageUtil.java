package top.jolyoulu.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: LZJ
 * @Date: 2020/5/27 21:11
 * @Version 1.0
 */
public class MessageUtil {

    /**
     * 解析reqString中xml格式消息
     * @param reqString HttpServletRequest
     * @return Map<节点名,值>
     */
    public static Map<String,String> string2Map(String reqString) {
        try {
            String xml = reqString;
            Map<String,String> maps = new HashMap<>();
            Document document = DocumentHelper.parseText(xml);
            Element root = document.getRootElement();
            List<Element> eles = root.elements();
            for (Element e:eles){
                maps.put(e.getName(),e.getTextTrim());
            }
            return maps;
        }catch (DocumentException e){
            e.printStackTrace();
        }
        return null;
    }

}
