package org.tang.springboot.redis.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
/**
 * @author 唐兴
 * @date   2017年8月21日
 * @desc   实现对象的序列化接口
 */
public class RedisObjectSerializable implements RedisSerializer<Object> {

	/**
	 * 序列化转换器
	 */
	private Converter<Object, byte[]> serializable = new SerializingConverter();
	
	
	/**
	 * 反序列化转换器
	 */
	private Converter<byte[],Object> deserializable = new DeserializingConverter();
	
	/**
	 * 空数组
	 */
	static final byte[] EMPTY_ARRAY = new byte[0];
	
	/**
	 * 序列化
	 */
	@Override
	public byte[] serialize(Object t) throws SerializationException {
		//如果对象为空，返回空数组
		if(t==null) {
			return EMPTY_ARRAY;
		}
		try {
		 return	serializable.convert(t);
		}catch(Exception e) {
			return EMPTY_ARRAY;
		}
	}
   
	/**
	 * 反序列化
	 */
	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		if(isEmpty(bytes)) {
			return null;
		}
		try {
			return deserializable.convert(bytes);
		}catch (Exception e) {
			throw new SerializationException("反序列化异常");
		}
	}

	
	/**
	 * 判断反序列话的值是否为空
	 * @param bytes
	 * @return
	 */
	private boolean isEmpty(byte[] bytes) {
		return bytes==null||bytes.length==0;
	}
	
}
