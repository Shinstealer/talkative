package com.shinstealler.talkative.service;

import java.util.List;

import com.shinstealler.talkative.model.response.CommonResult;
import com.shinstealler.talkative.model.response.ListResult;
import com.shinstealler.talkative.model.response.SingleResult;

import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    public enum CommonResponse {
        SUCCESS(0, "SUCCESS"), FAIL(-1, "FAIL");

        int code;
        String msg;

        private CommonResponse(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }

    }

    /**
     * 
     * @param data data
     * @return single result
     */
    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> singleResult = new SingleResult<>();
        singleResult.setData(data);
        setSuccessResult(singleResult);
        return singleResult;

    }

    public <T> ListResult<T> getListResult(List<T> list) {

        ListResult<T> listResult = new ListResult<>();
        listResult.setList(list);
        setSuccessResult(listResult);
        return listResult;

    }

    public CommonResult getSuccessResult() {
        CommonResult result = new CommonResult();
        setSuccessResult(result);
        return result;
    }

    public CommonResult getFailResult() {
        CommonResult result = new CommonResult();
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
        return result;
    }

    private void setSuccessResult(CommonResult result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }

}