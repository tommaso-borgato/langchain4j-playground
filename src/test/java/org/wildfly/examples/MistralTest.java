package org.wildfly.examples;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.mistralai.MistralAiChatModel;
import dev.langchain4j.model.mistralai.MistralAiChatModelName;
import org.junit.jupiter.api.Test;

public class MistralTest {

	@Test
	public void testMistral() {
		// https://console.mistral.ai/home
		// https://docs.langchain4j.dev/integrations/language-models/mistral-ai/
		// https://github.com/langchain4j/langchain4j/blob/main/langchain4j-mistral-ai/src/test/java/dev/langchain4j/model/mistralai/MistralAiChatModelIT.java

		System.out.println("Hello, World! " + System.getenv("MISTRAL_API_KEY"));

		ChatMemory memory = MessageWindowChatMemory.withMaxMessages(5);

		ChatLanguageModel model = MistralAiChatModel.builder()
				.apiKey(System.getenv("MISTRAL_API_KEY"))
				.modelName(MistralAiChatModelName.MISTRAL_SMALL_LATEST)
				.temperature(0.1)
				.logRequests(true)
				.logResponses(true)
				.build();

		UserMessage message1 = UserMessage.from("Hi! my name is Tommaso");
		memory.add(message1);
		AiMessage response1 = model.chat(memory.messages()).aiMessage();
		memory.add(response1);
		System.out.println(response1);

		UserMessage message2 = UserMessage.from("What my name is?");
		memory.add(message2);
		AiMessage response2 = model.chat(memory.messages()).aiMessage();
		memory.add(response2);
		System.out.println(response2);
	}
}