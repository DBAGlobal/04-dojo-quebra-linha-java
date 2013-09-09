package br.com.dojo.quebralinha;

public class TextFormatter {

	private TextFormatter() {
	}

	public static LineBroker forText(String text) {
		return new TextFormatter().new LineBroker(text);
	}

	public class LineBroker {
		private String[] tokenizedText;

		private LineBroker(String text) {
			tokenizedText = text.split("\\s");
		}

		public WordDelimiter limitWordsForLine() {
			return new TextFormatter().new WordDelimiter(tokenizedText);
		}

		public CharacterDelimiter limitCharactersForLine() {
			return new TextFormatter().new CharacterDelimiter(tokenizedText);
		}

	}

	public class WordDelimiter {

		private String[] words;

		private WordDelimiter(String[] words) {
			this.words = words;
		}

		public String to(Integer wordNumber) {

			StringBuilder builder = new StringBuilder();

			int count = 0;
			for (String word : words) {
				builder.append(word).append(" ");
				count++;
				if (count == wordNumber) {
					builder.append("\n");
					count = 0;
				}

			}
			return builder.toString();
		}
	}

	public class CharacterDelimiter {

		private String[] words;

		private CharacterDelimiter(String[] words) {
			this.words = words;
		}

		public String to(Integer columnNumber) {

			StringBuilder builder = new StringBuilder();

			int count = 0;
			for (String word : words) {
				if ( count > 0 ){
					if ( count + word.length() + 1 <= columnNumber){
						builder.append(" ").append(word);
						count += word.length() + 1;
					}
					else{
						builder.append("\n");
						builder.append(word);
						count = word.length();
					}
				}
				else{
					count = word.length();
					builder.append(word);
				}
				
			}
			return builder.toString();
		}
	}
}
