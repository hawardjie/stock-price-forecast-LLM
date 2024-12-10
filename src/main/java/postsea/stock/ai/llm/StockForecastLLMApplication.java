package postsea.stock.ai.llm;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StockForecastLLMApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockForecastLLMApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(ChatClient.Builder builder) {
		return args -> {
			ChatClient chatClient = builder.build();
			String response = chatClient.prompt("Analyze stock ticker AAPL").call().content();
			System.out.println(response);
		};
	}
}
