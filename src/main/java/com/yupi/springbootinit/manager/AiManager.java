package com.yupi.springbootinit.manager;

import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.exception.BusinessException;
import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* 用于对接AI平台
*/
@Service
public class AiManager {
    @Resource
    private YuCongMingClient yuCongMingClient;

    /**
     * AI对话
     *
     * @param message
     * @return
     */
    public String doChat(long modelId, String message) {
        // 构造请求参数
        DevChatRequest devChatRequest = new DevChatRequest();
        // 模型id 尾后加L转为Long类型
        devChatRequest.setModelId(modelId);
        devChatRequest.setMessage(message);
        // 获取响应结果
        BaseResponse<DevChatResponse> response = yuCongMingClient.doChat(devChatRequest);
        if (response == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "AI 响应错误");
        }

        return response.getData().getContent();
    }
}
