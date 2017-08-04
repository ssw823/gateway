package example;
import com.dtdream.uim.utils.SignatureHelper;
import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) throws Exception {
        testGetMethod();//详细注释请看testGetMethod方法
//        testPostMethod();
       // testRegionListMethod("http","127.0.0.1","8083","Ovrj1tzUVYaebXui","Js4daoJowzffGBUqf0eF7ucYRH4KSg");
    }

    /**
     * 获取region列表的无参数get请求示例
     */
    public static void testRegionListMethod(String protocol,String host,String port,String akId,String akSecret) throws Exception {
        Map<String,String> headers=new HashMap<String, String>();
        //签名加密算法，目前固定不变
        headers.put("SignatureMethod","HMAC-SHA256");

        //签名版本，目前固定不变
        headers.put("Version","20160701");

        //从DtCenter管控平台查看得到的用户AccessKeyId
        headers.put("AccessKeyId",akId);

        //传入参数为从DtCenter管控平台查看得到的用户AccessKeySecret
        //先用sdk计算签名，【注意：签名http方法参数和实际http的请求方式一致，即get就传入get，post就传入post】
        String signature = SignatureHelper.simpleSignRequest("post", headers, akSecret);
        //将签名放入头部
        headers.put("Signature",signature);
        //以上为构造http请求头的全部代码

        //传入请求头部，协议，host，端口号
        DtHttpRequest httpRequest=new DtHttpRequest(headers,protocol,host,port);

        //无请求参数，发送get请求
        String result = httpRequest.sendGet("gateway/api/region/list", null);

        //输出请求结果
        System.out.println(result);
    }

    /**
     * 获取OSS bucket详情的get方法示例
     */
    public static void testGetMethod() throws Exception {

        Map<String,String> headers=new HashMap<String, String>();
        //签名加密算法，目前固定不变
        headers.put("SignatureMethod","HMAC-SHA256");

        //签名版本，目前固定不变
        headers.put("Version","20160701");

        //从DtCenter管控平台查看得到的用户AccessKeyId
//        headers.put("AccessKeyId","UGwBFBTKglvzp9Bg");
        headers.put("AccessKeyId","kGa0nyuf1jsoKOWe");

        //传入参数为从DtCenter管控平台查看得到的用户AccessKeySecret
        //先用sdk计算签名，【注意：签名http方法参数和实际http的请求方式一致，即get就传入get，post就传入post】
//        String signature = SignatureHelper.simpleSignRequest("get", headers, "bFm4GaXrECRyclh5FDuanx6w4xo9c7");
        String signature = SignatureHelper.simpleSignRequest("get", headers, "7ZSCtRfbUAopU1jgWVpHeFqDgcatR2");
        //将签名放入头部
        headers.put("Signature",signature);
        //以上为构造http请求头的全部代码

        //传入请求头部，协议，host，端口号
        DtHttpRequest httpRequest=new DtHttpRequest(headers,"http","127.0.0.1","8083");

        //构造请求参数
        Map<String,String> param=new HashMap<String, String>();

        //区域ID，可以通过获取所有区域信息接口获得，请以正式环境中的为准
//        param.put("regionId","cn-hangzhou-am24");
        //bucket名称
//        param.put("bucketName","aaaa1");

        //传入请求参数，发送get请求
        String result = httpRequest.sendGet("gateway/api/cloudOss/read/getBucketInfo", param);

        //输出请求结果
        System.out.println(result);

    }

    /**
     * 创建ecs的 post方法示例
     */
    public static void testPostMethod() throws Exception {
        Map<String,String> headers=new HashMap<String, String>();
        //签名加密算法，目前固定不变
        headers.put("SignatureMethod","HMAC-SHA256");

        //签名版本，目前固定不变
        headers.put("Version","20160701");

        //从DtCenter管控平台查看得到的用户AccessKeyId
        headers.put("AccessKeyId","txccfnodHSszyqPk");

        //传入参数为从DtCenter管控平台查看得到的用户AccessKeySecret
        //先用sdk计算签名，【注意：签名http方法参数和实际http的请求方式一致，即get就传入get，post就传入post】
        String signature = SignatureHelper.simpleSignRequest("get", headers, "r9EfacprqZeTl372DKwdnvM2pmbe0U");
        //将签名放入头部
        headers.put("Signature",signature);
        //以上为构造http请求头的全部代码

        //传入请求头部，协议，host，端口号
        DtHttpRequest httpRequest=new DtHttpRequest(headers,"http","127.0.0.1","8083");
        //构造请求参数
        Map<String,String> param=new HashMap<String, String>();

        //设置公网出口带宽最大值，如果按带宽计费，范围0~100，单位Mbps；
        //如果按流量计费，范围1~100，单位Mbps。若为阿里公有云区域或者飞天专有云区域，该参数必须填写，若为DTCube区域，不填写该参数。
        param.put("bandwidth","1");

        //网络计费类型。若为阿里公有云区域或者飞天专有云区域，该参数必须填写，若为DTCube区域，不填写该参数。
        //取值：【PayByBandwidth：按带宽计费|PayByTraffic ： 按流量计费】
        param.put("chargeType","PayByTraffic");

        //cpu核数
        param.put("cpu","1");

        //创建数量
        param.put("createEcsNum","1");

        //部门ID，可通过获取部门树接口获取。
        param.put("departmentId","2");

        //镜像ID，可通过查询镜像列表接口获取
        param.put("imageId","aliyun1501_32_40G_aliaegis_20160222.vhd");

        //实例名称，由2~114个字符组成，以大小写字母或中文开头，只能包含字母数字、下划线和横杠。
        // 若为阿里公有云区域或者飞天专有云区域，该参数可以不填写，若为DTCube区域，该参数必须填写。
        param.put("instanceName","testEcs");

        //内存大小，单位是gb
        param.put("memory","1");

        //网络类型
        //classic：经典网络
        //vpc：专有网络
        param.put("networkType","vpc");
        //密码
        param.put("password","Admin123");
        //项目id
        param.put("projectId","78");
        //	区域ID，可通过获取所有区域信息接口获取。
        param.put("regionId","cn-hangzhou-am24");
        //安全组ID，可通过查询安全组列表接口获取。
        param.put("securityGroupId","sg-881z4rvpw");
        //系统盘类型。
        //取值：
        //cloud：  普通磁盘
        //cloud_ssd：  SSD磁盘
        //cloud_efficiency： 高效磁盘
        param.put("systemDiskType","cloud_ssd");

        //虚拟交换机ID，可通过获取虚拟交换机列表获取，当网络类型为专有网络时，该参数必须填写，当网络类型为经典网络时，不填写该参数。
        param.put("vSwitchId","vsw-88oby56u0");
        //专有网络ID，可通过查询专有网络列表获取，当网络类型为专有网络时，该参数必须填写，当网络类型为经典网络时，不填写该参数。
        param.put("vpcId","vpc-884lnnm4w");
        //可用区ID，可通过查询可用区列表接口-阿里云区域 获取。若为阿里公有云区域或者飞天专有云区域，该参数必须填写，若为DTCube区域，不填写该参数。
        param.put("zoneId","cn-hangzhou-hsd-am24001-a");

        //传入请求参数，发送post请求
        String result = httpRequest.sendPost("gateway/api/cloudEcs/manage/createDtcenterEcsInstance", param);
        //输出请求结果
        System.out.println(result);
    }

}
