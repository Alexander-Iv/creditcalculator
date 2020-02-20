package alexander.ivanov.creditcalculator.backend.util;

import org.modelmapper.ModelMapper;

public class ModelMapperUtils {
    private static final ModelMapper mapper = new ModelMapper();

    static {
        mapper.getConfiguration()
                .setSkipNullEnabled(true);
    }

    public static <S, D> D map(Class<S> sourceType, Class<D> targetType, S instance) {
        return mapper.typeMap(sourceType, targetType).map(instance);
    }
}
