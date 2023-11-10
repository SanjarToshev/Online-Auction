package uz.pdp.onlineauctiondemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.onlineauctiondemo.entity.User;
import uz.pdp.onlineauctiondemo.entity.UserCardInfo;
import uz.pdp.onlineauctiondemo.payload.CardInfoInput;
import uz.pdp.onlineauctiondemo.repository.UserCardInfoRepository;
import uz.pdp.onlineauctiondemo.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserCardInfoServive {
    private final UserRepository userRepository;
    private final UserCardInfoRepository userCardInfoRepository;

    public UserCardInfo addCard(CardInfoInput cardInfoInput, UUID id) {
        User user = userRepository.getById(id);
        UserCardInfo userCardInfo = new UserCardInfo();
        userCardInfo.setName(cardInfoInput.getName());
        userCardInfo.setUser(user);
        userCardInfo.setActive(true);
        userCardInfo.setCardNumber(cardInfoInput.getCardNumber());
        userCardInfo.setExpire(cardInfoInput.getExpire());
        return userCardInfoRepository.saveAndFlush(userCardInfo);
    }

    public UserCardInfo getCard(UUID cardId) {
        return userCardInfoRepository.getById(cardId);
    }

    public List<UserCardInfo> getAllCard() {
        return userCardInfoRepository.findAll();
    }

    public String deleteCard(UUID cardId) {
        UserCardInfo byId = userCardInfoRepository.getById(cardId);
        userCardInfoRepository.delete(byId);
        return "Deleted Succses";
    }
}
