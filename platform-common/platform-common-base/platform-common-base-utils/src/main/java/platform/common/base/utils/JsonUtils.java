package platform.common.base.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import platform.common.base.api.response.Result;

public class JsonUtils {
	private static ObjectMapper objectMapper = null;
	static {
		objectMapper = new ObjectMapper();
		// 从JSON到java object
		// 没有匹配的属性名称时不作失败处理
		objectMapper.setSerializationInclusion(Include.ALWAYS);
		objectMapper.configure(MapperFeature.AUTO_DETECT_FIELDS, true);

		// 反序列化
		// 禁止遇到空原始类型时抛出异常，用默认值代替。
		objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
		objectMapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
		// 禁止遇到未知（新）属性时报错，支持兼容扩展
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
		objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
		// 按时间戳格式读取日期
		// this.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS,
		// true);
		objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
		objectMapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		// 序列化
		// 禁止序列化空值
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
		// 按时间戳格式生成日期
		// this.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS,
		// true);
		objectMapper.configure(SerializationFeature.FLUSH_AFTER_WRITE_VALUE, true);
		// 不包含空值属性
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		// this.configure(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME, true);
		// 是否缩放排列输出，默认false，有些场合为了便于排版阅读则需要对输出做缩放排列
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, false);
		// 设置全局的时间转化
		SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		objectMapper.setDateFormat(smt);
		// 设置日期反序列化组件
		SimpleModule dateDeserializerModule = new SimpleModule();
		dateDeserializerModule.addDeserializer(Object.class, new DateDeseralizer());
		objectMapper.registerModule(dateDeserializerModule);
	}
	public static String toString(Object sourceObject) {
		try {
			return objectMapper.writeValueAsString(sourceObject);
		} catch (JsonProcessingException e) {
			LogUtils.throwableOutput(e);
		}
		return null;
	}
	public static <T> T parse(String sourceJsonString,Class<T> targetClass) {
		T targetObject=null;
		try {
			targetObject = objectMapper.readValue(sourceJsonString, targetClass);
		} catch (IOException e) {
			LogUtils.throwableOutput(e);
		}
		return targetObject;
	}
	public static void main(String[] args) {
		String json="{\"result\":\"1.0006666666666666655555555666661\"}";
		@SuppressWarnings("unchecked")
		Result<BigDecimal> re= parse(json,Result.class);
		System.err.println(re);
	}
	
}
