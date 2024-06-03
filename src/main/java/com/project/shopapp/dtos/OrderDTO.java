package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {
    @JsonProperty("user_id")
    @Min(value = 1, message = "User's ID must be > 0")
    private Long userId;

    // Define fullname
    @JsonProperty("fullname")
    private String fullName;

    // Define email
    private String email;

    // Define phone number
    @JsonProperty("phone_number")
    @NotBlank(message = "Phone number is required")
    @Size(min = 5, message = "Phone number must be at least 5 characters")
    private String phoneNumber;

    // Define status
    @JsonProperty("status")
    private String status;

    // Define address
    private String address;

    // Define note
    private String note;

    // Define total money
    @JsonProperty("total_money")
    @Min(value = 0, message = "Total money must be >= 0")
    private Float totalMoney;

    // Define shipping method
    @JsonProperty("shipping_method")
    private String shippingMethod;

    // Define shipping address
    @JsonProperty("shipping_address")
    private String shippingAddress;

    // Define shipping date
    @JsonProperty("shipping_date")
    private LocalDate shippingDate;

    // Define payment method
    @JsonProperty("payment_method")
    private String paymentMethod;
}
