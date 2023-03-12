package ca.mta.hacks.controller;

import ca.mta.hacks.dto.DecryptInfo;
import ca.mta.hacks.dto.EncryptInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class WebSocketController {

    @Autowired
    private EnigmaMachine enigmaMachine;

    @PostMapping("/encrypt")
    public ResponseEntity<String> joinGame(@RequestBody EncryptInfo encryptInfo) {
        String encrypted = enigmaMachine.encrypt(encryptInfo.encryptType(), encryptInfo.message());
        return ResponseEntity.ok().body(encrypted);
    }

    @PostMapping("/decrypt")
    public ResponseEntity<String> joinGame(@RequestBody DecryptInfo decryptInfo) {
        String decrypted = enigmaMachine.decrypt(decryptInfo.decryptType(), decryptInfo.message(), decryptInfo.key());
        return ResponseEntity.ok().body(decrypted);
    }
}
