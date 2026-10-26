# VAT Rates API - Ruby Gem

VAT Rates is a European VAT rates API: send a two-letter country code and get the current VAT rates for that country as JSON, with the full standard, reduced, super-reduced and parking set for EU members plus the UK, and standard rates for non-EU countries such as Switzerland and Norway. Paid plans add historical rates by date and regional exceptions by postcode.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_vatrates'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_vatrates
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_vatrates'

# Initialize the client
client = APIVerve::Vatrates::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  country: "DE",
  date: "2020-07-01",
  postcode: "35001"
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ country: "DE", date: "2020-07-01", postcode: "35001" })
  puts response["data"]
rescue APIVerve::Vatrates::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Vatrates::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Vatrates::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "country": "DE",
    "countryName": "Germany",
    "currency": "EUR",
    "effectiveFrom": "2021-01-01",
    "rates": {
      "standard": 19,
      "reduced": 7,
      "reduced2": null,
      "superReduced": null,
      "parking": null
    },
    "exception": null
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/vatrates?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/vatrates?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/vatrates?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
