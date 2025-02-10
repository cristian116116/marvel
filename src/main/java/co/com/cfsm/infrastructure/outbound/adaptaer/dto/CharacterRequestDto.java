package co.com.cfsm.infrastructure.outbound.adaptaer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterRequestDto {

	private String ts;

	private String hash;

	private String publicApikey;

}
