package com.example.housework.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.example.housework.vo.Message;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SendMessage {
    public void send(Object value,String tel,int type) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "....", "....");
        IAcsClient client = new DefaultAcsClient(profile);
        String obj = JSON.toJSONString(value);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", tel);
        request.putQueryParameter("SignName", "家政帮");
        if(type==0){
            request.putQueryParameter("TemplateCode", "SMS_183241482");
        }else if(type == 1){
            request.putQueryParameter("TemplateCode", "SMS_183241519");
        }
        request.putQueryParameter("TemplateParam", obj);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder code(){
        String str="0123456789";
        StringBuilder sb=new StringBuilder(4);
        for(int i=0;i<4;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return sb;
    }
}
