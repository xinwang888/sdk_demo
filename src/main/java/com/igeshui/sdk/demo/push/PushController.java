package com.igeshui.sdk.demo.push;

import com.google.gson.Gson;
import com.igeshui.sdk.common.Base64RASBase64Utils;
import com.igeshui.sdk.demo.push.dto.TaxDetailDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 接收推送信息
 * @author fanghao
 * @create 2018-01-22 10:39
 */
@RestController
@RequestMapping(value = "/")
public class PushController {

    /**
     * 私钥
     */
    private static final String privateKey =
            "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAOkR3M/LV8IufZq3YmuZedJtGt6JG4MktDtNLonFGq1qEhdJs9Etbd10ZyfjYBf7I7FVqU0aNfuWoJHzIzq8npmDrFuCRpAo+BurickcjeTXYPjQL/+o+A+qgNC/kMNP3QthCO9HzKC42gSX+UU3G2iUxHOhWWLlYOve+gq9nLl1AgMBAAECgYB79lU0bBnEHQgPRyRgyGOD6SXWYKQyb04xEE8FVcFnpLf0jO3H/tqlY6kODSBqANguFLqUWLGHm8jRd7kwH2xWhFf3uV0YAeZBURNRsQFRv8c0h+I+2n7d5D4pXGSPTNNCgNzo0GPrcC8pzhy68GUHyhO5NAlUS4QSmDrv1eWuIQJBAPcmiye2Z8yzH593FicnmS66DrB+7PPT9lurlzepZIwktHGsMTJ7zhv92povtMIBbepO6BmQiHCApkVTEitTf10CQQDxakAQu3bXci4D6oytgZiYzakn0O1dHykgcir2i8+mnEvycZ/s5utVNkdQqey5DRTLyof4XmF14Sjjnrrul7j5AkBJ27HgN0mDyc/cdtke8F19skprgjLLlv9bW8b/8lZC70Eha0T0gj0Q7mbihvkstQKk79m6sg+kFz4ZH38hhX1dAkAhaSEAr9EctBKmPBnIEX16+EuG1SVkk+FvOh20DVlpp4vjO9J0SOkc2+w2v62hVqwgICF9QCKg28564gbg6mKRAkBoBe4yDmquUPFGHI7i4biC/uev7G39pK+a0RH8MrCqo0DIPVtF3uVbdq+UMTqw70pn9rofL4W9fJvno8s0YVJz";



    @RequestMapping(value = "receiveMsg", method = RequestMethod.POST, produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public String receiveMsg(@RequestBody(required = false) String data) {
        String decryptJson = null;
        if (StringUtils.isNotBlank(data)) {
            //推送信息解码
            Gson gson = new Gson();
//            gson.fromJson(data,String.class);
//            decryptJson = Base64RASBase64Utils.decrypt(jsonData.getData(), privateKey);
            long start = System.currentTimeMillis();
            String json1 = Base64RASBase64Utils.decrypt(data, privateKey);
            System.out.println("消耗时间："+(System.currentTimeMillis() - start));

            //实体化
            TaxDetailDto taxDetailDto = gson.fromJson(json1, TaxDetailDto.class);
            System.out.println(taxDetailDto);
        }else {
            decryptJson = "未接受到推送信息！";
        }
        return decryptJson;
    }
}
