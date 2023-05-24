# Kbot

This is a simple Go application that reads messages from a Telegram bot and sends answers back to the user. It utilizes the Telegram Bot API to interact with the Telegram platform.

## Installation

Follow the steps below to set up and run the application:

1. Clone the repository using the following command:
   ```
   git clone https://github.com/daria-hrebonkina/kbot.git
   ```

2. Enter the project directory:
   ```
   cd kbot
   ```

3. Make a build specifying target OS and architecture (`linux` and `arm64` are used by default):
   ```
   make build TARGET_OS={YOUR_OS} TARGET_ARCH={YOUR_ARCHITECTURE}
   ```

4. Create a Telegram bot with BotFather:
   - Open Telegram and search for the BotFather bot.
   - Start a chat with BotFather and use the command `/newbot` to create a new bot.
   - Provide a name and a username for your bot when prompted.

5. Copy the access token provided by BotFather.

6. Run the following command to set the access token as an environment variable:
   ```
   read -s TELE_TOKEN
   ```
   - Paste your access token and press Enter.

7. Export the access token as an environment variable using the following command:
   ```
   export TELE_TOKEN
   ```

8. Start the application by running the following command:
   ```
   ./kbot start
   ```

9. Test the application using the Telegram bot link provided by BotFather.

## Usage

Once the application is running and connected to the Telegram bot, it will listen for incoming messages. You can interact with the bot using the Telegram app or any other method of communication supported by the Telegram platform.

The application will process the received messages and send appropriate responses back to the user.

## License

This project is licensed under the [MIT License](LICENSE).
