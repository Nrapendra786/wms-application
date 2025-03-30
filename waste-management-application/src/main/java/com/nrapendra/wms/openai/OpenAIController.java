package com.nrapendra.wms.openai;


import com.nrapendra.wms.wastecalculation.WasteCalculation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OpenAIController {

    private final OpenAiChatModel openAiChatModel;

    @Autowired
    public OpenAIController(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel=openAiChatModel;
    }

    @GetMapping("/joke-service/simple/{prompt}")
    public ResponseEntity<?> tellSimpleJoke(@PathVariable("prompt") String prompt) {
        PromptTemplate promptTemplate = new PromptTemplate(prompt);
        return new ResponseEntity<>(openAiChatModel.call(promptTemplate.getTemplate()),HttpStatus.OK);
    }

}
