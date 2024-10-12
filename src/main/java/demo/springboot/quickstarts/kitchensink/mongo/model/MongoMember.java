package demo.springboot.quickstarts.kitchensink.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("member")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MongoMember {
    @Id
    private String id;
    @Field("name")
    private String name;
    @Field("email")
    private String email;
    @Field("phoneNumber")
    private String phoneNumber;
}
