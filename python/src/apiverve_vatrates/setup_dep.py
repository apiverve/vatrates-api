from setuptools import setup, find_packages

setup(
    name='apiverve_vatrates',
    version='1.1.14',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='VAT Rates provides current and historical Value Added Tax rates for EU and non-EU countries. Includes standard, reduced, and special rates with support for regional exceptions.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/vatrates?utm_source=pypi&utm_medium=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
