# frozen_string_literal: true

Gem::Specification.new do |spec|
  spec.name          = "apiverve_vatrates"
  spec.version       = "1.2.3"
  spec.authors       = ["APIVerve"]
  spec.email         = ["hello@apiverve.com"]

  spec.summary       = "VAT Rates API - Ruby Client"
  spec.description   = "VAT Rates is a European VAT rates API: send a two-letter country code and get the current VAT rates for that country as JSON, with the full standard, reduced, super-reduced and parking set for EU members plus the UK, and standard rates for non-EU countries such as Switzerland and Norway. Paid plans add historical rates by date and regional exceptions by postcode."
  spec.homepage      = "https://apiverve.com/marketplace/vatrates?utm_source=ruby&utm_medium=referral&utm_content=homepage"
  spec.license       = "MIT"
  spec.required_ruby_version = ">= 2.7.0"

  spec.metadata["homepage_uri"] = spec.homepage
  spec.metadata["source_code_uri"] = "https://github.com/apiverve/vatrates-API/tree/main/ruby"
  spec.metadata["changelog_uri"] = "https://apiverve.com/changelog"
  spec.metadata["documentation_uri"] = "https://docs.apiverve.com/ref/vatrates"

  spec.files = Dir.glob("{lib}/**/*") + %w[README.md LICENSE]
  spec.require_paths = ["lib"]

  spec.add_dependency "faraday", ">= 1.0", "< 3.0"
  spec.add_dependency "faraday-multipart", "~> 1.0"
  spec.add_dependency "json", "~> 2.0"
end
