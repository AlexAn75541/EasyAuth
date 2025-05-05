package xyz.nikitacartes.easyauth.config;

import java.io.IOException;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.text.StringSubstitutor;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;

import com.google.common.io.Resources;
import static com.google.common.io.Resources.getResource;

import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import static net.minecraft.text.Text.translatable;
import static net.minecraft.text.Text.translatableWithFallback;
import static xyz.nikitacartes.easyauth.EasyAuth.langConfig;

@ConfigSerializable
public class LangConfigV1 extends ConfigTemplate {

    public boolean enableServerSideTranslation = false;
    public TranslatableText enterPassword = new TranslatableText("text.easyauth.enterPassword", "§6Bạn phải nhập mật khẩu!");
    public TranslatableText enterNewPassword = new TranslatableText("text.easyauth.enterNewPassword", "§4Bạn phải nhập mật khẩu mới!");
    public TranslatableText wrongPassword = new TranslatableText("text.easyauth.wrongPassword", "§4Mật khẩu không đúng!");
    public TranslatableText matchPassword = new TranslatableText("text.easyauth.matchPassword", "§6Mật khẩu không khớp!");
    public TranslatableText passwordUpdated = new TranslatableText("text.easyauth.passwordUpdated", "§aMật khẩu đã được cập nhật thành công!");
    public TranslatableText loginRequired = new TranslatableText("text.easyauth.loginRequired", "§cBạn chưa được đang nhập\n§6dùng /login, /l để đăng nhập!");
    public TranslatableText loginTriesExceeded = new TranslatableText("text.easyauth.loginTriesExceeded", "§4Bạn đã vượt quá số lần thử đăng nhập. Vui lòng thử lại sau vài phút!");
    public TranslatableText globalPasswordSet = new TranslatableText("text.easyauth.globalPasswordSet", "§aMật khẩu toàn cầu đã được đặt thành công!");
    public TranslatableText cannotChangePassword = new TranslatableText("text.easyauth.cannotChangePassword", "§cBạn không thể thay đổi mật khẩu của tài khoản này!");
    public TranslatableText cannotUnregister = new TranslatableText("text.easyauth.cannotUnregister", "§cBạn không thể hủy đăng ký tài khoản này!");
    public TranslatableText notAuthenticated = new TranslatableText("text.easyauth.notAuthenticated", "§cBạn chưa được đăng ký\n§6Hãy thử với /login, /l hoặc /register nếu vẫn chưa đăng ký!");
    public TranslatableText alreadyAuthenticated = new TranslatableText("text.easyauth.alreadyAuthenticated", "§6Bạn đã được đăng nhập rồi!");
    public TranslatableText successfullyAuthenticated = new TranslatableText("text.easyauth.successfullyAuthenticated", "§aBạn đã đăng nhập thành công!");
    public TranslatableText successfulLogout = new TranslatableText("text.easyauth.successfulLogout", "§aBạn đã đăng xuất thành công!");
    public TranslatableText timeExpired = new TranslatableText("text.easyauth.timeExpired", "§cThời gian đăng nhập đã hết hạn.");
    public TranslatableText registerRequired = new TranslatableText("text.easyauth.registerRequired", "§6Hãy gõ /register <mật khẩu> <nhập lại mật khẩu> để đăng ký tài khoản.");
    public TranslatableText alreadyRegistered = new TranslatableText("text.easyauth.alreadyRegistered", "§6Tài khoản này đã được đăng ký rồi!");
    public TranslatableText registerSuccess = new TranslatableText("text.easyauth.registerSuccess", "§aTài khoản đã được đăng ký thành công");
    public TranslatableText userdataDeleted = new TranslatableText("text.easyauth.userdataDeleted", "§aUserdata deleted");
    public TranslatableText userdataUpdated = new TranslatableText("text.easyauth.userdataUpdated", "§aUserdata updated.");
    public TranslatableText accountDeleted = new TranslatableText("text.easyauth.accountDeleted", "§aTài khoản đã được xóa thành công.");
    public TranslatableText configurationReloaded = new TranslatableText("text.easyauth.configurationReloaded", "§aFile config đã được tải lại thành công");
    public TranslatableText maxPasswordChars = new TranslatableText("text.easyauth.maxPasswordChars", "§6Mật khẩu đã vượt quá %d kí tự!");
    public TranslatableText minPasswordChars = new TranslatableText("text.easyauth.minPasswordChars", "§6Mật khẩu phải trên %dkí tự!");
    public TranslatableText disallowedUsername = new TranslatableText("text.easyauth.disallowedUsername", "§6Tên người chơi không hợp lệ! Dải kí tự tên cho phép: %s");
    public TranslatableText playerAlreadyOnline = new TranslatableText("text.easyauth.playerAlreadyOnline", "§cNgười chơi %s đã đăng nhập rồi!");
    public TranslatableText worldSpawnSet = new TranslatableText("text.easyauth.worldSpawnSet", "§aĐiểm hồi sinh đã được đặt thành công");
    public TranslatableText corruptedPlayerData = new TranslatableText("text.easyauth.corruptedPlayerData", "§cDữ liệu người chơi bị hỏng. Vui lòng liên hệ với quản trị viên máy chủ.");
    public TranslatableText userNotRegistered = new TranslatableText("text.easyauth.userNotRegistered", "§cNgười chơi này chưa được đăng ký!");
    public TranslatableText cannotLogout = new TranslatableText("text.easyauth.cannotLogout", "§cBạn không thể đăng xuất tài khoản này");
    public TranslatableText offlineUuid = new TranslatableText("text.easyauth.offlineUuid", "Offline UUID của %s là %s");
    public TranslatableText registeredPlayers = new TranslatableText("text.easyauth.registeredPlayers", "Danh sách những người đã đăng kí:");
    public TranslatableText validSession = new TranslatableText("text.easyauth.validSession", "§aPhiên đăng nhập hợp lệ. Bạn có thể đăng nhập mà không cần mật khẩu.");
    public TranslatableText onlinePlayerLogin = new TranslatableText("text.easyauth.onlinePlayerLogin", "§aBạn đã đăng nhập thành công với tài khoản online(premium). Bạn có thể đăng nhập lại mà không cần mật khẩu.");
    public TranslatableText differentUsernameCase = new TranslatableText("text.easyauth.diffrentUsernameCase", "§6Tên người chơi không khớp với tên đã đăng kí. Vui lòng kiểm tra lại tên người chơi của bạn.");
    public TranslatableText wrongGlobalPassword = new TranslatableText("text.easyauth.wrongGlobalPassword", "§4Mật khẩu toàn cầu không đúng!");
    public TranslatableText registerRequiredWithGlobalPassword = new TranslatableText("text.easyauth.registerRequiredWithGlobalPassword", "§6Hãy ghi /register <Mật khẩu toàn cầu> <Mật khẩu> <mật khẩu> để đăng kí tài khoản.");
    public TranslatableText markAsOffline = new TranslatableText("text.easyauth.markAsOffline", "§aPlayer %s đã đánh dấu là offline");
    public TranslatableText markAsOnline = new TranslatableText("text.easyauth.markAsOnline", "§aPlayer %s đã đánh dấu là online");
    public TranslatableText selfMarkAsOnline = new TranslatableText("text.easyauth.selfMarkAsOnline", "§aBạn đã đánh dấu tài khoản này là online(premium)");
    public TranslatableText selfMarkAsOnlineWarning = new TranslatableText("text.easyauth.selfMarkAsOnlineWarning", "§6Bạn đang chuẩn bị đánh dấu tài khoản sang loại online(premium)\n§6Bạn sẽ không đăng nhập được vào nếu không có tài khoản premium\n§6Dữ liệu đã liên kết với tài khoảng có UUID offline như thú nuôi, giảm giá của dân làng sẽ bị mất.\n§aNếu bạn muốn tiếp tục /account online <mật khẩu> true.");

    public LangConfigV1() {
        super("translation.conf");
    }

    public static LangConfigV1 create() {
        LangConfigV1 config = loadConfig(LangConfigV1.class, "translation.conf");
        if (config == null) {
            config = new LangConfigV1();
            config.save();
        }
        return config;
    }

    public static LangConfigV1 load() {
        LangConfigV1 config = loadConfig(LangConfigV1.class, "translation.conf");
        if (config == null) {
            throw new RuntimeException("Failed to load translation.conf");
        }
        return config;
    }

    protected String handleTemplate() throws IOException {
        Map<String, Object> configValues = new HashMap<>();
        configValues.put("enableServerSideTranslation", wrapIfNecessary(enableServerSideTranslation));
        configValues.put("enterPassword", wrapIfNecessary(enterPassword));
        configValues.put("enterNewPassword", wrapIfNecessary(enterNewPassword));
        configValues.put("wrongPassword", wrapIfNecessary(wrongPassword));
        configValues.put("matchPassword", wrapIfNecessary(matchPassword));
        configValues.put("passwordUpdated", wrapIfNecessary(passwordUpdated));
        configValues.put("loginRequired", wrapIfNecessary(loginRequired));
        configValues.put("loginTriesExceeded", wrapIfNecessary(loginTriesExceeded));
        configValues.put("globalPasswordSet", wrapIfNecessary(globalPasswordSet));
        configValues.put("cannotChangePassword", wrapIfNecessary(cannotChangePassword));
        configValues.put("cannotUnregister", wrapIfNecessary(cannotUnregister));
        configValues.put("notAuthenticated", wrapIfNecessary(notAuthenticated));
        configValues.put("alreadyAuthenticated", wrapIfNecessary(alreadyAuthenticated));
        configValues.put("successfullyAuthenticated", wrapIfNecessary(successfullyAuthenticated));
        configValues.put("successfulLogout", wrapIfNecessary(successfulLogout));
        configValues.put("timeExpired", wrapIfNecessary(timeExpired));
        configValues.put("registerRequired", wrapIfNecessary(registerRequired));
        configValues.put("alreadyRegistered", wrapIfNecessary(alreadyRegistered));
        configValues.put("registerSuccess", wrapIfNecessary(registerSuccess));
        configValues.put("userdataDeleted", wrapIfNecessary(userdataDeleted));
        configValues.put("userdataUpdated", wrapIfNecessary(userdataUpdated));
        configValues.put("accountDeleted", wrapIfNecessary(accountDeleted));
        configValues.put("configurationReloaded", wrapIfNecessary(configurationReloaded));
        configValues.put("maxPasswordChars", wrapIfNecessary(maxPasswordChars));
        configValues.put("minPasswordChars", wrapIfNecessary(minPasswordChars));
        configValues.put("disallowedUsername", wrapIfNecessary(disallowedUsername));
        configValues.put("playerAlreadyOnline", wrapIfNecessary(playerAlreadyOnline));
        configValues.put("worldSpawnSet", wrapIfNecessary(worldSpawnSet));
        configValues.put("corruptedPlayerData", wrapIfNecessary(corruptedPlayerData));
        configValues.put("userNotRegistered", wrapIfNecessary(userNotRegistered));
        configValues.put("cannotLogout", wrapIfNecessary(cannotLogout));
        configValues.put("offlineUuid", wrapIfNecessary(offlineUuid));
        configValues.put("registeredPlayers", wrapIfNecessary(registeredPlayers));
        configValues.put("validSession", wrapIfNecessary(validSession));
        configValues.put("onlinePlayerLogin", wrapIfNecessary(onlinePlayerLogin));
        configValues.put("differentUsernameCase", wrapIfNecessary(differentUsernameCase));
        configValues.put("wrongGlobalPassword", wrapIfNecessary(wrongGlobalPassword));
        configValues.put("registerRequiredWithGlobalPassword", wrapIfNecessary(registerRequiredWithGlobalPassword));
        configValues.put("markAsOffline", wrapIfNecessary(markAsOffline));
        configValues.put("markAsOnline", wrapIfNecessary(markAsOnline));
        configValues.put("selfMarkAsOnline", wrapIfNecessary(selfMarkAsOnline));
        configValues.put("selfMarkAsOnlineWarning", wrapIfNecessary(selfMarkAsOnlineWarning));

        String configTemplate = Resources.toString(getResource("data/easyauth/config/" + configPath), UTF_8);
        return new StringSubstitutor(configValues).replace(configTemplate);
    }

    public static final class TranslatableText {
        private final String key;
        public final String fallback;
        public final boolean enabled;
        public final boolean serverSide;

        public TranslatableText(String key, String fallback) {
            this.key = key;
            this.fallback = fallback;
            this.enabled = true;
            this.serverSide = true;
        }

        public TranslatableText(String key, String fallback, boolean enabled, boolean serverSide) {
            this.key = key;
            this.fallback = fallback;
            this.enabled = enabled;
            this.serverSide = serverSide;
        }

        public void send(ServerCommandSource commandOutput) {
            if (enabled && commandOutput != null) {
                if (langConfig.enableServerSideTranslation && serverSide) {
                    commandOutput.sendMessage(translatable(key));
                } else {
                    commandOutput.sendMessage(Text.literal(fallback));
                }
            }
        }

        public <T extends CommandOutput> void send(T commandOutput) {
            if (enabled && commandOutput != null) {
                if (langConfig.enableServerSideTranslation && serverSide) {
                    commandOutput.sendMessage(translatable(key));
                } else {
                    commandOutput.sendMessage(Text.literal(fallback));
                }
            }
        }

        public void send(ServerCommandSource commandOutput, Object... args) {
            if (enabled && commandOutput != null) {
                if (langConfig.enableServerSideTranslation && serverSide) {
                    commandOutput.sendMessage(translatable(key, args));
                } else {
                    commandOutput.sendMessage(translatable(fallback, args));
                }
            }
        }

        public MutableText get() {
            if (enabled) {
                if (langConfig.enableServerSideTranslation && serverSide) {
                    return translatable(key);
                } else {
                    return Text.literal(fallback);
                }
            } else {
                return Text.literal("");
            }
        }

        public MutableText get(Object... args) {
            if (enabled) {
                if (langConfig.enableServerSideTranslation && serverSide) {
                    return translatable(key, args);
                } else {
                    return translatable(fallback, args);
                }
            } else {
                return Text.literal("");
            }
        }

        public MutableText getWithFallback() {
            if (enabled) {
                if (langConfig.enableServerSideTranslation && serverSide) {
                    return translatableWithFallback(key, fallback);
                } else {
                    return Text.literal(fallback);
                }
            } else {
                return Text.literal("");
            }
        }

        public MutableText getWithFallback(Object... args) {
            if (enabled) {
                if (langConfig.enableServerSideTranslation && serverSide) {
                    return translatableWithFallback(key, fallback, args);
                } else {
                    return translatable(fallback, args);
                }
            } else {
                return Text.literal("");
            }
        }
    }

}
