# VAT Rates API - PHP Package

VAT Rates is a European VAT rates API: send a two-letter country code and get the current VAT rates for that country as JSON, with the full standard, reduced, super-reduced and parking set for EU members plus the UK, and standard rates for non-EU countries such as Switzerland and Norway. Paid plans add historical rates by date and regional exceptions by postcode.

## Installation

Install via Composer:

```bash
composer require apiverve/vatrates
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Vatrates\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'country' => 'DE',
    'date' => '2020-07-01',
    'postcode' => '35001'
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Vatrates\Client;
use APIVerve\Vatrates\Exceptions\APIException;
use APIVerve\Vatrates\Exceptions\ValidationException;

try {
    $response = $client->execute(['country' => 'DE', 'date' => '2020-07-01', 'postcode' => '35001']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/vatrates?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/vatrates?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/vatrates?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
