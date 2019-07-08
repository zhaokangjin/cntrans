package platform.common.base.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;

/**
 * 支持多种日期格式的解析
 */
@SuppressWarnings("deprecation")
class DateDeseralizer extends UntypedObjectDeserializer {

	private static final long serialVersionUID = -2275951539867772400L;

	public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

		if (jp.getCurrentTokenId() == JsonTokenId.ID_STRING) {
			try {
				return DateUtils.parseDate(jp.getText(),
						new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "MM/dd/yyyy",
								"yyyy.MM.dd G 'at' HH:mm:ss z", "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
								"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "EEE, dd MMM yyyy HH:mm:ss zzz" });
			} catch (Exception e) {
				return super.deserialize(jp, ctxt);
			}
		} else {
			return super.deserialize(jp, ctxt);
		}
	}
}