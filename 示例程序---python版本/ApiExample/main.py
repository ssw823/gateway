import rpc_signature_composer as rpc_signer
import sha_hmac256 as mac256
import requests

signer = mac256.ShaHmac256()
rpcSigner = rpc_signer.RpcSignature()

# 从DtCenter管控平台查看得到的用户AccessKeyId
accessKeyId = 'AXqd0yXZugnpJHLV'

# 从DtCenter管控平台查看得到的用户AccessKeySecret
accessKeySec = 'p9OThNqbfrVoa7Y9FPrYvGcYNdBzeb'

# 构造请求头部
headerParam = {"Version": '20160701',
               "SignatureMethod": 'HMAC-SHA256',
               "AccessKeyId": accessKeyId}

# 传入请求头部，AccessKeyId，AccessKeySecret，构造完整的请求头部，即包含signature字段，共四个四段的头部
headers = rpcSigner.get_signed_url(headerParam, accessKeyId, accessKeySec, None, 'POST', signer)

# 请求参数

urlParam = {
    # 设置公网出口带宽最大值，如果按带宽计费，范围0~100，单位Mbps；
    # 如果按流量计费，范围1~100，单位Mbps。若为阿里公有云区域或者飞天专有云区域，该参数必须填写，若为DTCube区域，不填写该参数。
    "bandwidth": "1",

    # 网络计费类型。若为阿里公有云区域或者飞天专有云区域，该参数必须填写，若为DTCube区域，不填写该参数。
    # 取值：【PayByBandwidth：按带宽计费|PayByTraffic ： 按流量计费】
    "chargeType": "PayByTraffic",

    # cpu核数
    "cpu": "1",

    # 创建数量
    "createEcsNum": "1",

    # 部门ID，可通过获取部门树接口获取。
    "departmentId": "2",

    # 镜像ID，可通过查询镜像列表接口获取
    "imageId": "aliyun1501_32_40G_aliaegis_20160222.vhd",

    # 实例名称，由2~114个字符组成，以大小写字母或中文开头，只能包含字母数字、下划线和横杠。
    # 若为阿里公有云区域或者飞天专有云区域，该参数可以不填写，若为DTCube区域，该参数必须填写。
    "instanceName": "testEcsPython",

    # 内存大小，单位是gb
    "memory": "1",

    # 网络类型【classic：经典网络，vpc：专有网络】
    "networkType": "vpc",

    # 密码
    "password": "Admin123",

    # 项目id
    "projectId": "78",

    # 区域ID，可通过获取所有区域信息接口获取。
    "regionId": "cn-hangzhou-am24",

    # 安全组ID，可通过查询安全组列表接口获取。
    "securityGroupId": "sg-881z4rvpw",

    # 系统盘类型。
    # 取值：
    # cloud：  普通磁盘
    # cloud_ssd：  SSD磁盘
    # cloud_efficiency： 高效磁盘
    "systemDiskType": "cloud_ssd",

    #虚拟交换机ID，可通过获取虚拟交换机列表获取，当网络类型为专有网络时，该参数必须填写，当网络类型为经典网络时，不填写该参数。
    "vSwitchId": "vsw-88oby56u0",

    #专有网络ID，可通过查询专有网络列表获取，当网络类型为专有网络时，该参数必须填写，当网络类型为经典网络时，不填写该参数。
    "vpcId": "vpc-884lnnm4w",

    #可用区ID，可通过查询可用区列表接口-阿里云区域 获取。若为阿里公有云区域或者飞天专有云区域，该参数必须填写，若为DTCube区域，不填写该参数。
    "zoneId": "cn-hangzhou-hsd-am24001-a"
}
# 发送请求
result = requests.post("http://127.0.0.1:8083/gateway/api/cloudEcs/manage/createDtcenterEcsInstance", urlParam,
                       headers=headers)
print (result.content)
