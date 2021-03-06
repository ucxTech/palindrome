package com.ucx.utility.palindrome.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ucx.utility.palindrome.dto.PalindromeRequestDto;
import com.ucx.utility.palindrome.dto.PalindromeResponseDto;
import com.ucx.utility.palindrome.service.PalindromeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("helper")
public class PalindromeController {

    private final PalindromeService palindromeService;

    public PalindromeController(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    @PostMapping
    public Map<String, Boolean> isPalindrome(@RequestBody Map<String, String> input){
        Map<String, Boolean> resultMap = new HashMap<>();
        boolean result = palindromeService.isPalindrome(input.get("text"));
        resultMap.put("isPalindrome", result);
        return resultMap;
    }

    /**
     * manipulohut vet convertimi objektit ne Json
     * @param input
     * @return
     */
    @PostMapping("palindrome1")
    public JsonNode isPalindrome1(@RequestBody Map<String, String> input){
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objNode = objectMapper.createObjectNode();
        boolean result = palindromeService.isPalindrome(input.get("text"));
        objNode.put("isPalindrome", result);
        return objNode;
    }

    @PostMapping("palindrome2")
    public PalindromeResponseDto palindromeRequest(@Valid @RequestBody PalindromeRequestDto input){
        PalindromeResponseDto palindromeResponseDto = new PalindromeResponseDto();
        boolean result = palindromeService.isPalindrome(input.getText());
        palindromeResponseDto.setPalindrome(result);
        return palindromeResponseDto;
    }

    @PostMapping("palindrome3")
    public ResponseEntity<PalindromeResponseDto> palindromeRequest3(@RequestBody PalindromeRequestDto input){
        PalindromeResponseDto palindromeResponseDto = new PalindromeResponseDto();
        boolean result = palindromeService.isPalindrome(input.getText());
        palindromeResponseDto.setPalindrome(result);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(palindromeResponseDto);
    }

    @GetMapping("palindrome4")
    public ResponseEntity<PalindromeResponseDto> palindromeRequest4(@RequestParam String text){
        PalindromeResponseDto palindromeResponseDto = new PalindromeResponseDto();
        boolean result = palindromeService.isPalindrome(text);
        palindromeResponseDto.setPalindrome(result);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(palindromeResponseDto);
    }
}
