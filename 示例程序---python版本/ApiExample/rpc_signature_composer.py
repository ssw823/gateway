# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.

#coding=utf-8
import sha_hmac256 as mac
import parameter_helper as helper
import urllib

class RpcSignature(object):
    """docstring for Rpc_signature"""
    def __init__(self):
        super(RpcSignature, self).__init__()



    # this function will append the necessary parameters for signer process.
    # parameters: the orignal parameters
    # signer: sha_hmac1 or sha_hmac256
    # accessKeyId: this is aliyun_access_key_id
    # format: XML or JSON
    def __refresh_sign_parameters(self,parameters, access_key_id, accept_format="JSON", signer=mac):
        if parameters is None or not isinstance(parameters, dict):
            parameters = dict()
        # parameters["Timestamp"] = helper.get_iso_8061_date()
        # parameters["SignatureMethod"] = signer.get_signer_name()
        # parameters["SignatureVersion"] = signer.get_singer_version()
        # parameters["SignatureNonce"] = helper.get_uuid()
        # parameters["AccessKeyId"] = access_key_id
        if accept_format is not None:
            parameters["Format"] = accept_format
        return parameters


    # this method will given the
    #
    def __compose_string_to_sign(self, method, queries):
        canonicalized_query_string = ""
        sorted_parameters = sorted(queries.items(), key=lambda queries: queries[0])
        for (k, v) in sorted_parameters:
            canonicalized_query_string += '&' + helper.percent_encode(k) + '=' + helper.percent_encode(v)
        sign_to_string = method + "&%2F&" + helper.percent_encode(canonicalized_query_string[1:])
        return sign_to_string


    def __get_signature(self, string_to_sign, secret, signer=mac):
        return signer.get_sign_string(string_to_sign, secret + '&')


    def get_signed_url(self, params, ak, secret, accept_format, method, signer=mac):
        sign_params = self.__refresh_sign_parameters(params, ak, accept_format, signer)
        string_to_sign = self.__compose_string_to_sign(method, sign_params)
        signature = self.__get_signature(string_to_sign, secret, signer)
        sign_params['Signature'] = signature
        # url = '/?' + urllib.urlencode(sign_params)
        return sign_params

