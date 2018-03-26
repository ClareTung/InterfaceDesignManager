package cn.iponkan.service;

import cn.iponkan.util.DigestUtil;
import cn.iponkan.util.HttpClientUtils;
import cn.iponkan.util.PageData;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("managerService")
public class ManagerService {

    public String getJson(int parameter) {
        //封装请求信息
        PageData htp = new PageData();
        htp.put("version","1");
        htp.put("r",String.valueOf((int)(Math.random()*100)));
        htp.put("parameter",String.valueOf(parameter));
        //签名
        htp.put("sign", DigestUtil.toSign(htp));

        //发送请求，获得返回数据
        String json = HttpClientUtils.doPost("http://localhost:8100/api/getJson.do",htp);

        //可对数据进行处理
        Map map = JSON.parseObject(json);

        //签名验证失败
        if(map.get("errCode").toString().equals("100")){
            return map.get("errMsg").toString();
        }

        //这里直接返回整个json串，看一下效果
        return json;
    }

}
